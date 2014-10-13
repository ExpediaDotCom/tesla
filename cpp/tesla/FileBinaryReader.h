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

#ifndef FILEBINARYREADER_H_
#define FILEBINARYREADER_H_

#include <tesla/binary/BinaryReader.h>
#include <tesla/SchemaVersion.h>

namespace tesla {

template<class FileStream>
class BasicFileBinaryReader: public BasicBinaryReader<FileStream> {
public:
	typedef FileStream Stream;
	typedef typename Stream::char_type char_type;

	explicit BasicFileBinaryReader(const char* path, SchemaVersion const& ver =
			SchemaVersion(), typename Stream::openmode mod = Stream::in
			| Stream::binary) :
		BasicBinaryReader<Stream> (&stream_, ver), stream_(path, mod) {
		if (!stream_.good()) {
			throw DeserializationException(std::string("Failed to open input "
				"file") + path);
		}
	}

protected:
	Stream stream_;
};

typedef BasicFileBinaryReader<std::ifstream> FileBinaryReader;

}

#endif /* FILEBINARYREADER_H_ */
