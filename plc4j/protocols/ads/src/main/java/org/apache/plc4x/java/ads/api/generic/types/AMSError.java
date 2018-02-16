/*
 Licensed to the Apache Software Foundation (ASF) under one
 or more contributor license agreements.  See the NOTICE file
 distributed with this work for additional information
 regarding copyright ownership.  The ASF licenses this file
 to you under the Apache License, Version 2.0 (the
 "License"); you may not use this file except in compliance
 with the License.  You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing,
 software distributed under the License is distributed on an
 "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 KIND, either express or implied.  See the License for the
 specific language governing permissions and limitations
 under the License.
 */
package org.apache.plc4x.java.ads.api.generic.types;

import io.netty.buffer.ByteBuf;
import org.apache.plc4x.java.ads.api.commands.types.AdsReturnCode;
import org.apache.plc4x.java.ads.api.util.UnsignedIntLEByteValue;

public class AMSError extends UnsignedIntLEByteValue {

    private static final int NUM_BYTES = UnsignedIntLEByteValue.NUM_BYTES;

    public static final AMSError NONE = of(0);

    private AMSError(byte... values) {
        super(values);
    }

    private AMSError(long value) {
        super(value);
    }

    private AMSError(ByteBuf byteBuf) {
        super(byteBuf);
    }

    public static AMSError of(byte... values) {
        return new AMSError(values);
    }

    private static AMSError of(long errorCode) {
        checkUnsignedBounds(errorCode, NUM_BYTES);
        return new AMSError(errorCode);
    }

    public static AMSError of(ByteBuf byteBuf) {
        return new AMSError(byteBuf);
    }

    private AdsReturnCode toAdsReturnCode() {
        return AdsReturnCode.of(getAsLong());
    }

    @Override
    public String toString() {
        return "AMSError{" + toAdsReturnCode() + "}";
    }
}