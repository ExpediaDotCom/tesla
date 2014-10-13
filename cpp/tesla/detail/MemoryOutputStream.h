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
