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
