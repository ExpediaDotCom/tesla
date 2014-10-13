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

#ifndef FILEBINARYWRITER_H_
#define FILEBINARYWRITER_H_

#include <tesla/binary/BinaryWriter.h>
#include <tesla/SchemaVersion.h>

namespace tesla {

template<class FileStream>
class BasicFileBinaryWriter: public BasicBinaryWriter<FileStream> {
public:
	typedef FileStream Stream;
	typedef typename Stream::char_type char_type;

	explicit BasicFileBinaryWriter(const char* path, SchemaVersion const& ver =
			SchemaVersion(), typename Stream::openmode mod = Stream::out
			| Stream::binary) :
		BasicBinaryWriter<Stream> (&stream_, ver), stream_(path, mod) {
		if (!stream_.good()) {
			throw SerializationException(std::string("Failed to open output "
				"file") + path);
		}
	}

protected:
	Stream stream_;
};

typedef BasicFileBinaryWriter<std::ofstream> FileBinaryWriter;

}

#endif /* FILEBINARYWRITER_H_ */
