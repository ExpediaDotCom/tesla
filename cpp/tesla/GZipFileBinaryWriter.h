/*
 * GZipFileBinaryWriter.h
 *
 *  Created on: Aug 20, 2013
 *      Author: yzuo
 */

#ifndef GZIPFILEBINARYWRITER_H_
#define GZIPFILEBINARYWRITER_H_

#include <boost/iostreams/filtering_stream.hpp>
#include <boost/iostreams/filter/gzip.hpp>
#include <boost/iostreams/device/file.hpp>

#include <tesla/binary/BinaryWriter.h>
#include <tesla/SchemaVersion.h>

namespace tesla {

class GZipFileBinaryWriter: public BasicBinaryWriter<
		boost::iostreams::filtering_ostream> {
public:
	typedef boost::iostreams::filtering_ostream Stream;
	typedef Stream::char_type char_type;

	explicit GZipFileBinaryWriter(const char* path, SchemaVersion const& ver =
			SchemaVersion(), Stream::openmode mod = Stream::out
			| Stream::binary) :
		BasicBinaryWriter<Stream> (&stream_, ver) {
		stream_.push(boost::iostreams::gzip_compressor());
		stream_.push(boost::iostreams::file_sink(path, Stream::trunc
				| Stream::out | Stream::binary));

		if (!stream_.good()) {
			throw SerializationException(std::string("Failed to open output "
				"file") + path);
		}
	}

protected:
	Stream stream_;
};

}
#endif /* GZIPFILEBINARYWRITER_H_ */
