/*
 * Copyright @ 2018 - present 8x8, Inc.
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
package org.jitsi.xmpp.extensions.jingleinfo;

import org.jitsi.xmpp.extensions.*;

import org.jivesoftware.smack.packet.*;

/**
 * Relay packet extension.
 *
 * @author Sebastien Vincent
 */
public class RelayPacketExtension
    extends AbstractPacketExtension
{
    /**
     * The namespace.
     */
    public static final String NAMESPACE = "google:jingleinfo";

    /**
     * The element name.
     */
    public static final String ELEMENT_NAME = "relay";

    /**
     * The token.
     */
    private String token = null;

    /**
     * Constructor.
     */
    public RelayPacketExtension()
    {
        super(NAMESPACE, ELEMENT_NAME);
    }

    /**
     * Set the token.
     *
     * @param token token
     */
    public void setToken(String token)
    {
        this.token = token;
    }

    /**
     * Get the token.
     *
     * @return authentication token
     */
    public String getToken()
    {
        return token;
    }

    /**
     * Get an XML string representation.
     *
     * @return XML string representation
     */
    @Override
    public String toXML()
    {
        StringBuilder bld = new StringBuilder();

        bld.append("<").append(ELEMENT_NAME).append(">");

        if(token != null)
        {
            bld.append("<").append("token").append(">");
            bld.append(token);
            bld.append("</").append("token").append(">");
        }

        for(ExtensionElement pe : getChildExtensions())
        {
            bld.append(pe.toXML());
        }
        bld.append("</").append(ELEMENT_NAME).append(">");

        return bld.toString();
    }
}