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
