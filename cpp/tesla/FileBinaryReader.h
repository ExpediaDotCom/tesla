/*
 * FileBinaryReader.h
 *
 *  Created on: Aug 20, 2013
 *      Author: Yunfei Zuo (yzuo@expedia.com)
 */

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
