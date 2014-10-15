TESTS = MemoryBinaryReaderTest FileBinaryReaderTest GZipFileBinaryReaderTest \
        MemoryBinaryWriterTest FileBinaryWriterTest GZipFileBinaryWriterTest

check_PROGRAMS = MemoryBinaryReaderTest FileBinaryReaderTest GZipFileBinaryReaderTest \
 		 MemoryBinaryWriterTest FileBinaryWriterTest GZipFileBinaryWriterTest

include_HEADERS = *.h

MemoryBinaryReaderTest_SOURCES = BinaryReaderTest.cpp
FileBinaryReaderTest_SOURCES = BinaryReaderTest.cpp
GZipFileBinaryReaderTest_SOURCES = BinaryReaderTest.cpp
MemoryBinaryWriterTest_SOURCES = BinaryWriterTest.cpp
FileBinaryWriterTest_SOURCES = BinaryWriterTest.cpp
GZipFileBinaryWriterTest_SOURCES = BinaryWriterTest.cpp


MemoryBinaryReaderTest_CPPFLAGS = 
FileBinaryReaderTest_CPPFLAGS = -DUSE_FILE_STREAM
GZipFileBinaryReaderTest_CPPFLAGS = -DUSE_GZIP_FILE_STREAM
MemoryBinaryWriterTest_CPPFLAGS =
FileBinaryWriterTest_CPPFLAGS = -DUSE_FILE_STREAM
GZipFileBinaryWriterTest_CPPFLAGS = -DUSE_GZIP_FILE_STREAM


AM_LDFLAGS = $(CPPUNIT_LIBS) $(BOOST_IOSTREAMS_LIB)


