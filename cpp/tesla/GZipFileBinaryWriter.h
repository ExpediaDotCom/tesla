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
