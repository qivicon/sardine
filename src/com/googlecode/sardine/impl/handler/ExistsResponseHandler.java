/*
 * Copyright 2009-2011 Jon Stevens et al.
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
 */

package com.googlecode.sardine.impl.handler;

import com.googlecode.sardine.util.SardineException;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;

import java.io.IOException;

/**
 * {@link org.apache.http.client.ResponseHandler} which checks wether a given resource exists.
 *
 * @author mirko
 * @version $Id$
 */
public final class ExistsResponseHandler extends ValidatingResponseHandler<Boolean>
{
	public Boolean handleResponse(HttpResponse response) throws ClientProtocolException, IOException
	{
		final StatusLine statusLine = response.getStatusLine();
		final int statusCode = statusLine.getStatusCode();
		if (statusCode < HttpStatus.SC_MULTIPLE_CHOICES)
		{
			return true;
		}
		if (statusCode == HttpStatus.SC_NOT_FOUND)
		{
			return false;
		}
		throw new SardineException(statusLine.getReasonPhrase(), statusCode, statusLine.getReasonPhrase());
	}
}