/* ============================================================================
*
* FILE: BasicFileSharingAgent.java
*
The MIT License (MIT)

Copyright (c) 2016 Sutanu Dalui

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
*
* ============================================================================
*/
package com.reactivetechnologies.platform.rest;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Component;

import com.reactivetechnologies.platform.Configurator;
import com.reactivetechnologies.platform.files.AbstractFileSharingAgent;
import com.reactivetechnologies.platform.files.FileChunkHandler;
import com.reactivetechnologies.platform.files.io.BufferedStreamChunkHandler;
import com.reactivetechnologies.platform.files.io.MemoryMappedChunkHandler;
/**
 * A file sharing agent with basic (OIO) file handler.
 */
@Component
public class BasicFileSharingAgent extends AbstractFileSharingAgent {

  public BasicFileSharingAgent() {
    super();
  }
  @Override
  protected FileChunkHandler newWriteHandler(String dirPath) throws IOException {
    return new BufferedStreamChunkHandler(dirPath);
  }

  @Override
  protected FileChunkHandler newReadHandler(File f) throws IOException {
    return new MemoryMappedChunkHandler(f, Configurator.DEFAULT_CHUNK_SIZE_BYTES);
  }

}
