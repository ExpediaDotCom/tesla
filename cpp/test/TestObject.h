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

#pragma once

// stl
#include <iostream>

#include <tesla/detail/types.h>

struct TestObject {
    int m;

    TestObject(int n = 0) :
        m(n) {
    }

    template<typename Reader>
    void deserialize(Reader& reader) {
        reader.read(tesla::TeslaType_Int32(), "m", m);
    }

    template<typename Writer>
    void serialize(Writer& writer) const {
        writer.write(tesla::TeslaType_Int32(), "m", m);
    }

    bool operator==(const TestObject& oth) const {
        return m == oth.m;
    }

    bool operator<(const TestObject& oth) const {
        return m < oth.m;
    }

    friend std::ostream& operator<<(std::ostream& os, const TestObject&);
};

std::ostream& operator<<(std::ostream& os, const TestObject& o) {
    os << "{ m = " << o.m << " } ";
    return os;
}

enum Day { Sunday, Monday, Tuesday, Wednesday, Thursday, Friday, Saturday };
