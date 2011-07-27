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

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.xml.namespace.QName;

import org.switchyard.admin.Application;
import org.switchyard.admin.Service;

/**
 * Base implementation of Application.
 */
public class BaseApplication implements Application {
    
    private BaseSwitchYard _switchYard;
    private QName _name;
    private Map<QName, Service> _services;
    
    /**
     * Create a new BaseApplication with the specified services.
     * @param switchYard SwitchYard object containing this application
     * @param name application name
     * @param services list of services
     */
    public BaseApplication(BaseSwitchYard switchYard, QName name, List<Service> services) {
        this(switchYard, name);
        if (services != null) {
            for (Service service : services) {
                _services.put(service.getName(), service);
            }
        }
    }

    /**
     * Create a new BaseApplication.
     * @param switchYard SwitchYard object containing this application
     * @param name application name
     */
    public BaseApplication(BaseSwitchYard switchYard, QName name) {
        _switchYard = switchYard;
        _name = name;
        _services = new LinkedHashMap<QName, Service>();
    }

    @Override
    public QName getName() {
        return _name;
    }

    @Override
    public List<Service> getServices() {
        if (_services == null) {
            return Collections.emptyList();
        }
        return new ArrayList<Service>(_services.values());
    }
    
    /**
     * Set the list of services offered by this application.
     * @param services list of services
     */
    public void setServices(List<Service> services) {
        _services = new LinkedHashMap<QName, Service>();
        for (Service service : services) {
            _services.put(service.getName(), service);
        }
    }

    protected void addService(Service service) {
        _services.put(service.getName(), service);
        _switchYard.addService(service);
    }
    
    protected Service removeService(QName serviceName) {
        Service service = _services.remove(serviceName);
        if (service != null) {
            _switchYard.removeService(service);
        }
        return service;
    }
}
