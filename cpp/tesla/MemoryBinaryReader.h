/*******************************************************************************
 * Copyright (c) 2014 Expedia Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/

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
