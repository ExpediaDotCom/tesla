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
