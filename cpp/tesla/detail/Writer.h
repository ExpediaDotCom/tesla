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
