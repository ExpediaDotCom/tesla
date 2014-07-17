(function(global) {
    'use strict';
    function OutputStream() {
        this.capacity = 8;
        this.buffer = new ArrayBuffer(this.capacity);
        this.byteBuffer = new Uint8Array(this.buffer);
        this.lenght = 0;
        this.floatbuffer = new ArrayBuffer(8);
        this.floatByteBuffer = new Uint8Array(this.floatbuffer);
        this.float32Buffer = new Float32Array(this.floatbuffer);
        this.float64Buffer = new Float64Array(this.floatbuffer);
    }

    OutputStream.prototype.writeByte = function(b) {
            this.ensure();
            this.byteBuffer[this.lenght] = b;
            this.lenght++;
        }

    OutputStream.prototype.writeInt16 = function(value) {
        this.writeVInt(((value << 1) ^ (value >> 15)) & 0xffff);
        }

    OutputStream.prototype.writeUInt16 = function(value) {
        this.writeVInt(value);
        }

    OutputStream.prototype.writeInt32 = function(value) {
        this.writeVInt(((value << 1) ^ (value >> 31)) & 0xffffffff);
        }

    OutputStream.prototype.writeUInt32 = function(value) {
        this.writeVInt(value);
        }

    OutputStream.prototype.writeFloat = function(value) {
            this.float32Buffer[0] = value;
            this.ensure(4);
            this.byteBuffer[this.lenght++] = this.floatByteBuffer[0];
            this.byteBuffer[this.lenght++] = this.floatByteBuffer[1];
            this.byteBuffer[this.lenght++] = this.floatByteBuffer[2];
            this.byteBuffer[this.lenght++] = this.floatByteBuffer[3];
        }

    OutputStream.prototype.writeDouble = function(value) {
        this.float64Buffer[0] = value;
        this.ensure(8);
        this.byteBuffer[this.lenght++] = this.floatByteBuffer[0];
        this.byteBuffer[this.lenght++] = this.floatByteBuffer[1];
        this.byteBuffer[this.lenght++] = this.floatByteBuffer[2];
        this.byteBuffer[this.lenght++] = this.floatByteBuffer[3];
        this.byteBuffer[this.lenght++] = this.floatByteBuffer[4];
        this.byteBuffer[this.lenght++] = this.floatByteBuffer[5];
        this.byteBuffer[this.lenght++] = this.floatByteBuffer[6];
        this.byteBuffer[this.lenght++] = this.floatByteBuffer[7];
    }

    OutputStream.prototype.writeBoolean = function(value) {
        this.writeVInt(value ? 0x0D : 0x05);
    }

    OutputStream.prototype.writeString = function(value) {
        var len = value.length;
        this.writeVInt(len);
        // UTF-8 encoding
        for (var i = 0; i < len; i++) {

            var codePoint = value.charCodeAt(i);
            if (codePoint <= 0x7F) {
                this.writeByte(codePoint);  
            } else if (codePoint <= 0x7FF) {
                this.writeByte(0xC0 + (codePoint / 0x40));
                this.writeByte(0x80 + (codePoint % 0x40));
            } else if (codePoint <= 0xFFFF) {
                this.writeByte(0xE0 + (codePoint / 0x1000));
                this.writeByte(0x80 + ((codePoint / 0x40) % 0x40));
                this.writeByte(0x80 + (codePoint % 0x40));
            } else if (codePoint <= 0x1FFFFF) {
                this.writeByte(0xF0 + (codePoint / 0x40000));
                this.writeByte(0x80 + ((codePoint / 0x1000) % 0x40));
                this.writeByte(0x80 + ((codePoint / 0x40) % 0x40));
                this.writeByte(0x80 + (codePoint % 0x40));
            } else if (codePoint <= 0x3FFFFFF) {
                this.writeByte(0xF0 + (codePoint / 0x1000000));
                this.writeByte(0xF0 + (codePoint / 0x40000) % 0x40);
                this.writeByte(0x80 + ((codePoint / 0x1000) % 0x40));
                this.writeByte(0x80 + ((codePoint / 0x40) % 0x40));
                this.writeByte(0x80 + (codePoint % 0x40));
            } else if (codePoint <= 0x7FFFFFFF) {
                this.writeByte(0xFC + (codePoint / 0x40000000));
                this.writeByte(0x80 + ((codePoint / 0x10000000) % 0x40));
                this.writeByte(0x80 + ((codePoint / 0x40000) % 0x40));
                this.writeByte(0x80 + ((codePoint / 0x1000) % 0x40));
                this.writeByte(0x80 + ((codePoint / 0x40) % 0x40));
                this.writeByte(0x80 + (codePoint % 0x40));
            }
        }

    }

    OutputStream.prototype.writeVInt = function(value) {
            do {
                // TODO: Investigate unrolling
                var lsb = (value & 0x7f);
                this.writeByte(lsb | ((value >>= 7) == 0 ? 0 : 0x80));
            } while (value != 0);
        }

    OutputStream.prototype.ensure = function(len) {
            len = len || 1;
            if (this.capacity < this.lenght + len) {
                this.capacity *= 2;
                var newBuffer = new ArrayBuffer(this.capacity);
                var newByteBuffer = new Uint8Array(newBuffer);
                newByteBuffer.set(this.byteBuffer);
                this.buffer = newBuffer;
                this.byteBuffer = newByteBuffer;
            }
        }


    function InputStream(data) {
        if (!(data instanceof ArrayBuffer))
            throw "invalid input data.";

        this.data = data;
        this.byteBuffer = new Uint8Array(this.data);
        this.pos = 0;

        this.floatbuffer = new ArrayBuffer(8);
        this.floatByteBuffer = new Uint8Array(this.floatbuffer);
        this.float32Buffer = new Float32Array(this.floatbuffer);
        this.float64Buffer = new Float64Array(this.floatbuffer);
    }

    InputStream.prototype.readByte = function() {
        if (this.pos + 1 > this.data.lenght)
            throw "reached the end of buffer";
        return this.byteBuffer[this.pos++];
    }

    InputStream.prototype.readInt16 = function() {
        return this.readZigZag();
    }

    InputStream.prototype.readInt32 = function() {
        return this.readZigZag();
    }

    InputStream.prototype.readUInt16 = function() {
        return this.readVInt();
    }

    InputStream.prototype.readUInt32 = function() {
        return this.readVInt();
    }

    InputStream.prototype.readBoolean = function() {
        var b = this.readByte();
        if (b == 0x0D)
            return true;
        else if (b == 0x05)
            return false;
        throw "Invalid boolean value.";
    }

    InputStream.prototype.readFloat = function() {
        this.floatByteBuffer[0] = this.byteBuffer[this.pos++];
        this.floatByteBuffer[1] = this.byteBuffer[this.pos++];
        this.floatByteBuffer[2] = this.byteBuffer[this.pos++];
        this.floatByteBuffer[3] = this.byteBuffer[this.pos++];
        return this.float32Buffer[0];
    }

    InputStream.prototype.readDouble = function() {
        this.floatByteBuffer[0] = this.byteBuffer[this.pos++];
        this.floatByteBuffer[1] = this.byteBuffer[this.pos++];
        this.floatByteBuffer[2] = this.byteBuffer[this.pos++];
        this.floatByteBuffer[3] = this.byteBuffer[this.pos++];
        this.floatByteBuffer[4] = this.byteBuffer[this.pos++];
        this.floatByteBuffer[5] = this.byteBuffer[this.pos++];
        this.floatByteBuffer[6] = this.byteBuffer[this.pos++];
        this.floatByteBuffer[7] = this.byteBuffer[this.pos++];
        return this.float64Buffer[0];
    }

    InputStream.prototype.readString = function() {
        var size = this.readVInt();
        var codePoints = [];
        var count = 0;

        while (count < size) {
            var b1 = this.readByte();
            count++;
            if (b1 <= 0x7F) { // 0x00, 0x7F: 1 byte
                codePoints.push(b1);
            } else if (b1 <= 0xDF) { // 0xC2, 0xDF: 2 bytes
                var b2 = this.readByte();
                count++;
                codePoints.push(((b1 & 0x1F) << 6) | (b2 & 0x3F));
            } else if (b1 <= 0xEF) { // 0xE0, 0xEF: 3 bytes
                var b2 = this.readByte();
                var b3 = this.readByte();
                count += 2;
                codePoints.push(((b1 & 0x0F) << 12) | ((b2 & 0x3F) << 6) | (b3 & 0x3F));
            } else if (b1 <= 0xF7) { // 0xF0, 0xF7: 4 bytes
                var b2 = this.readByte();
                var b3 = this.readByte();
                var b4 = this.readByte();
                count += 3;
                codePoints.push(((b1 & 0x07) << 18) | ((b2 & 0x3F) << 12) | ((b3 & 0x3F) << 6) | (b4 & 0x3F));
            } else if (b1 <= 0xFB) { // 0xF8, 0xFB: 5 bytes
                var b2 = this.readByte();
                var b3 = this.readByte();
                var b4 = this.readByte();
                var b5 = this.readByte();
                count += 4;
                codePoints.push(((b1 & 0x03) << 24) | ((b2 & 0x3F) << 18) | ((b3 & 0x3F) << 12) | ((b4 & 0x3F) << 6) | (b5 & 0x3F));
            } else if (b1 <= 0xFD) { // 0xFD: 6 bytes
                var b2 = this.readByte();
                var b3 = this.readByte();
                var b4 = this.readByte();
                var b5 = this.readByte();
                var b6 = this.readByte();
                count += 5;
                codePoints.push(((b1 & 0x01) << 30) | ((b2 & 0x3F) << 24) | ((b3 & 0x3F) << 18) | ((b4 & 0x3F) << 12) | ((b5 & 0x3F) << 6) | (b6 & 0x3F));
            }
        }
        return String.fromCharCode.apply(null, codePoints);
    }

    InputStream.prototype.readVInt = function() {
        var nVal = 0, b = 0, noBits = 0;
        do {
            if (noBits >= 64) // No more than 64 bits.
                throw "Invalid or corrupt serialized stream detected: invalid LEB128 value.";
            b = this.readByte();
            nVal |= (b & 0x7F) << noBits;
            noBits += 7;
        } while (b & 0x80);
        return nVal;
    }

    InputStream.prototype.readZigZag = function() {
        var n = this.readVInt();
        return (n >> 1) ^ -(n & 1); 
    }

}(this));
