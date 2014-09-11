/*
 * SchemaVersion.h
 *
 *  Created on: Aug 22, 2013
 *      Author: Yunfei Zuo (yzuo@expedia.com)
 */

#ifndef SCHEMAVERSION_H_
#define SCHEMAVERSION_H_
#pragma once

#include <tesla/tbase.h>

namespace tesla {

#define DEFINE_PROPERTY(n, t)                                                   \
    public:                                                                     \
        t n() const {                                                           \
            return n##_;                                                        \
        }                                                                       \
        t n(const t& v) {                                                       \
            t tmp = n##_;                                                       \
            n##_ = v;                                                           \
            return tmp;                                                         \
        }                                                                       \
    private:                                                                    \
        t n##_;

class SchemaVersion {
DEFINE_PROPERTY(hash, int64_t)
DEFINE_PROPERTY(name, std::string)
DEFINE_PROPERTY(number, short)

public:
    explicit SchemaVersion(int64_t hash = 0, const char* name = "", short number = 0) :
        hash_(hash), name_(name), number_(number) {
    }
};

}

#endif /* SCHEMAVERSION_H_ */
