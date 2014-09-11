/*
 * FileBinaryWriter.h
 *
 *  Created on: Aug 20, 2013
 *      Author: Yunfei Zuo (yzuo@expedia.com)
 */

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
