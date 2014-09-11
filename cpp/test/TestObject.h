
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
