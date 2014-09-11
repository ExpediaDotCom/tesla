/*
 * MemoryBinaryReader.h
 *
 *  Created on: Aug 20, 2013
 *      Author: Yunfei Zuo (yzuo@expedia.com)
 */

#ifndef MEMORYBINARYREADER_H_
#define MEMORYBINARYREADER_H_

#include <tesla/tbase.h>
#include <tesla/detail/MemoryInputStream.h>
#include <tesla/binary/BinaryReader.h>
#include <tesla/SchemaVersion.h>

namespace tesla {

class MemoryBinaryReader : public BasicBinaryReader<MemoryInputStream> {
public:
    typedef MemoryInputStream Stream;
    typedef Stream::char_type char_type;

    explicit MemoryBinaryReader(const Buffer& buf, SchemaVersion const& ver =
            SchemaVersion()) :
        BasicBinaryReader<MemoryInputStream>(&stream_, ver), stream_(buf) {
    }

    MemoryBinaryReader(const void* buf, size_t size) :
        BasicBinaryReader<MemoryInputStream>(&stream_), stream_(
                static_cast<const char_type*> (buf), size) {
    }

protected:

    Stream stream_;
};

}

#endif /* MEMORYBINARYREADER_H_ */
