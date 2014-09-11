/*
 * GZipFileBinaryReader.h
 *
 *  Created on: Aug 20, 2013
 *      Author: Yunfei Zuo (yzuo@expedia.com)
 */

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
