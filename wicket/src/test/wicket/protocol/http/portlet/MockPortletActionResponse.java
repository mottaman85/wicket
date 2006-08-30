/*
 * $Id: org.eclipse.jdt.ui.prefs 5004 2006-03-17 20:47:08 -0800 (Fri, 17 Mar 2006) eelco12 $
 * $Revision: 5004 $
 * $Date: 2006-03-17 20:47:08 -0800 (Fri, 17 Mar 2006) $
 * 
 * ==============================================================================
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package wicket.protocol.http.portlet;

import java.io.IOException;
import java.util.Map;

import javax.portlet.ActionResponse;
import javax.portlet.PortletMode;
import javax.portlet.PortletModeException;
import javax.portlet.WindowState;
import javax.portlet.WindowStateException;

import wicket.protocol.http.MockHttpServletResponse;

/**
 * 
 * Mock implementation of PortletActionResponse
 * 
 * @author Janne Hietam&auml;ki (jannehietamaki)
 */
public class MockPortletActionResponse extends MockPortletResponse implements ActionResponse
{

	Map<String, Object> renderParameters;
	/**
	 * Construct.
	 * @param resp
	 * @param renderParameters 
	 */
	public MockPortletActionResponse(MockHttpServletResponse resp,Map<String,Object> renderParameters)
	{
		super(resp);
		this.renderParameters=renderParameters;
	}

	public void sendRedirect(String url) throws IOException
	{
		resp.sendRedirect(url);
	}

	public void setPortletMode(PortletMode mode) throws PortletModeException
	{
	}

	public void setRenderParameter(String key, String value)
	{
		renderParameters.put(key,value);
	}

	public void setRenderParameter(String key, String[] values)
	{
		renderParameters.put(key,values);		
	}

	@SuppressWarnings("unchecked")
	public void setRenderParameters(Map parameters)
	{
		renderParameters=parameters;
	}

	public void setWindowState(WindowState state) throws WindowStateException
	{
	}
}