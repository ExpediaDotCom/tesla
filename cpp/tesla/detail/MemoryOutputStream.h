/*
 * MemoryOutputStream.h
 *
 *  Created on: Aug 19, 2013
 *      Author: yzuo
 */

#ifndef MEMORYOUTPUTSTREAM_H_
#define MEMORYOUTPUTSTREAM_H_

#include <ios>
#include <tesla/tbase.h>

namespace tesla {

class MemoryOutputStream {
public:
    typedef char char_type;
    typedef std::char_traits<char> char_traits;
    typedef Buffer::size_type size_type;

    explicit MemoryOutputStream(size_type initSize = 65536) : buffer_(internalBuffer_) {
        internalBuffer_.reserve(initSize);
    }

    explicit MemoryOutputStream(Buffer& buffer) : buffer_(buffer) {
    }

    bool good() const {
        return true;
    }

    MemoryOutputStream& put(char_type c) {
        buffer_.push_back(static_cast<Buffer::value_type> (c));
        return *this;
    }

    MemoryOutputStream& write(const char_type* s, std::streamsize n) {
        if (n > 0) {
            size_t oldSize = buffer_.size();
            buffer_.resize(oldSize + n);
            std::memcpy(&buffer_[oldSize], s, n);
        }
        return *this;
    }

    const Buffer& buffer() const {
        return buffer_;
    }

protected:

    Buffer internalBuffer_;
    Buffer& buffer_;
};

}

#endif /* MEMORYOUTPUTSTREAM_H_ */
