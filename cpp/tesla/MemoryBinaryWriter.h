/*
 * MemoryBinaryWriter.h
 *
 *  Created on: Aug 20, 2013
 *      Author: Yunfei Zuo (yzuo@expedia.com)
 */

#ifndef MEMORYBINARYWRITER_H_
#define MEMORYBINARYWRITER_H_

#include <tesla/tbase.h>
#include <tesla/detail/MemoryOutputStream.h>
#include <tesla/binary/BinaryWriter.h>

namespace tesla {

class MemoryBinaryWriter: public BasicBinaryWriter<MemoryOutputStream> {
public:
    typedef MemoryOutputStream Stream;
    typedef Stream::char_type char_type;

    explicit MemoryBinaryWriter(size_t initSize = 65536, SchemaVersion const& ver = SchemaVersion()) :
        BasicBinaryWriter<Stream> (&stream_, ver), stream_(initSize) {
    }

    explicit MemoryBinaryWriter(Buffer& buffer, SchemaVersion const& ver = SchemaVersion()) :
        BasicBinaryWriter<Stream> (&stream_, ver), stream_(buffer) {
    }

    const Buffer& buffer() const {
        return stream_.buffer();
    }

protected:

    Stream stream_;
};

}

#endif /* MEMORYBINARYWRITER_H_ */
