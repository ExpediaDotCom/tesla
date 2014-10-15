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

#ifndef GZIPFILEBINARYREADER_H_
#define GZIPFILEBINARYREADER_H_

#include <boost/iostreams/filtering_stream.hpp>
#include <boost/iostreams/filter/gzip.hpp>
#include <boost/iostreams/device/file.hpp>

#include <tesla/binary/BinaryReader.h>
#include <tesla/SchemaVersion.h>

namespace tesla {

class GZipFileBinaryReader: public BasicBinaryReader<
        boost::iostreams::filtering_istream> {
public:
    typedef boost::iostreams::filtering_istream Stream;
    typedef Stream::char_type char_type;

    explicit GZipFileBinaryReader(const char* path, SchemaVersion const& ver = SchemaVersion(), Stream::openmode mod = Stream::in
            | Stream::binary) :
        BasicBinaryReader<Stream> (&stream_, ver) {
        stream_.push(boost::iostreams::gzip_decompressor());
        stream_.push(boost::iostreams::file_source(path, mod));
        if (!stream_.good()) {
            throw DeserializationException(std::string("Failed to open input "
                "file") + path);
        }
    }

protected:
    Stream stream_;
};

}

#endif /* GZIPFILEBINARYREADER_H_ */
