/*
 * rwbase.h
 *
 * Tesla reader/writer base
 *
 *  Created on: Dec 2, 2013
 *      Author: Yunfei Zuo (yzuo@expedia.com)
 */

#ifndef TESLARWBASE_H_
#define TESLARWBASE_H_

#include <tesla/SchemaVersion.h>

namespace  tesla {

template<class Stream>
class RWBase {
protected:
	explicit RWBase(Stream* stream, SchemaVersion const& ver)
		: stream_(stream), ver_(ver) {
		assert(stream_);
	}
public:
	SchemaVersion const& version() const {
		return ver_;
	}
protected:
    Stream* stream_;
    SchemaVersion ver_;
};

}

#endif /* TESLARWBASE_H_ */
