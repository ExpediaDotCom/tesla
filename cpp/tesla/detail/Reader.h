/*
 * Reader.h
 *
 *  Created on: Aug 19, 2013
 *      Author: Yunfei Zuo (yzuo@expedia.com)
 */

#ifndef TESLAREADER_H_
#define TESLAREADER_H_

#pragma once

#include <tesla/tbase.h>
#include <tesla/detail/rwbase.h>

namespace tesla {

template <typename Stream>
class Reader : public RWBase<Stream> {
public:
    struct ReaderTag {
    };

protected:
    explicit Reader(Stream* stream, SchemaVersion const& ver)
    	: RWBase<Stream>(stream, ver) {
    }
};

}

#endif /* TESLAREADER_H_ */
