/* 
 * JBoss, Home of Professional Open Source 
 * Copyright 2011 Red Hat Inc. and/or its affiliates and other contributors
 * as indicated by the @author tags. All rights reserved. 
 * See the copyright.txt in the distribution for a 
 * full listing of individual contributors.
 *
 * This copyrighted material is made available to anyone wishing to use, 
 * modify, copy, or redistribute it subject to the terms and conditions 
 * of the GNU Lesser General Public License, v. 2.1. 
 * This program is distributed in the hope that it will be useful, but WITHOUT A 
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A 
 * PARTICULAR PURPOSE.  See the GNU Lesser General Public License for more details. 
 * You should have received a copy of the GNU Lesser General Public License, 
 * v.2.1 along with this distribution; if not, write to the Free Software 
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, 
 * MA  02110-1301, USA.
 */
package org.switchyard.admin.base;

import javax.xml.namespace.QName;

import org.switchyard.admin.ComponentReference;

/**
 * BaseComponentReference
 * 
 * Base implementation for {@link ComponentReference}.
 * 
 * @author Rob Cernich
 */
public class BaseComponentReference implements ComponentReference {

    private final QName _name;
    private final String _interface;
    private final MessageMetricsSupport _messageMetrics = new MessageMetricsSupport();

    /**
     * Create a new BaseComponentReference.
     * 
     * @param name the name of the reference
     * @param interfaceName the required interface
     */
    public BaseComponentReference(QName name, String interfaceName) {
        _name = name;
        _interface = interfaceName;
    }

    @Override
    public QName getName() {
        return _name;
    }

    @Override
    public String getInterface() {
        return _interface;
    }

    @Override
    public MessageMetricsSupport getMessageMetrics() {
        return _messageMetrics;
    }
}
