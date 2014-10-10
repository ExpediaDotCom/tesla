/*
 * MemoryInputStream.h
 *
 *  Created on: Aug 19, 2013
 *      Author: yzuo
 */

#ifndef MEMORYINPUTSTREAM_H_
#define MEMORYINPUTSTREAM_H_

#include <cstring>
#include <ios>

#include <tesla/tbase.h>

namespace tesla {

class MemoryInputStream {
public:
    typedef char char_type;
    typedef std::char_traits<char> char_traits;
    typedef Buffer::size_type size_type;
    typedef MemoryInputStream ThisType;

    explicit MemoryInputStream(const Buffer& buf) :
        buf_(reinterpret_cast<const char_type*> (&buf.front())), pos_(0),
                size_(buf.size()), good_(true) {
    }

    MemoryInputStream(const SBuffer& buf) :
        buf_(reinterpret_cast<const char_type*> (&buf.front())), pos_(0),
                size_(buf.size()), good_(true) {
    }

    MemoryInputStream(const char_type* buf, size_type size) :
        buf_(buf), pos_(0), size_(size), good_(true) {
    }

    bool good() const {
        return good_;
    }

    ThisType& get(char_type& c) {
        c = (pos_ < size_) ? buf_[pos_++] : (good_ = false, char_traits::eof());
        return *this;
    }

    ThisType& read(char_type* s, std::streamsize size) {
        if (pos_ + size > size_) {
            good_ = false;
        } else {
            std::memcpy(s, &(buf_[pos_]), size);
            pos_ += size;
        }
        return *this;
    }

protected:

    const char_type* buf_;
    std::streamsize pos_;
    std::streamsize size_;
    bool good_;
};

}

#endif /* MEMORYINPUTSTREAM_H_ */
