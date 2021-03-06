/*
 * Licensed to Elastic Search and Shay Banon under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. Elastic Search licenses this
 * file to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.xbib.elasticsearch.action.langdetect;

import java.io.IOException;
import org.elasticsearch.action.support.single.custom.SingleCustomOperationRequest;
import org.elasticsearch.common.bytes.BytesReference;
import org.elasticsearch.common.io.stream.StreamInput;
import org.elasticsearch.common.io.stream.StreamOutput;

public class LangdetectRequest extends SingleCustomOperationRequest<LangdetectRequest> {

    BytesReference text;

    public LangdetectRequest() {
    }

    public LangdetectRequest setText(BytesReference text) {
        this.text = text;
        return this;
    }
    
    public BytesReference getText() {
        return text;
    }
    
    @Override
    public void readFrom(StreamInput in) throws IOException {
        super.readFrom(in);
        text = in.readBytesReference();
    }

    @Override
    public void writeTo(StreamOutput out) throws IOException {
        super.writeTo(out);
        out.writeBytesReference(text);
    }
}
