/*
 * Writer.h
 *
 *  Created on: Aug 19, 2013
 *      Author: Yunfei Zuo (yzuo@expedia.com)
 */

#ifndef TESLAWRITER_H_
#define TESLAWRITER_H_

#include <tesla/tbase.h>
#include <tesla/detail/rwbase.h>

namespace tesla {

template <typename Stream>
class Writer : public RWBase<Stream> {
public:
    struct WriterTag {
    };

protected:
    explicit Writer(Stream* stream, SchemaVersion const& ver)
    	: RWBase<Stream>(stream, ver) {
    }
};

}

#endif /* TESLAWRITER_H_ */
