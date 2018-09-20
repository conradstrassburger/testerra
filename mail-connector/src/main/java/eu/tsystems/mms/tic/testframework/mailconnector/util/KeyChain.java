/*
 * (C) Copyright T-Systems Multimedia Solutions GmbH 2018, ..
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
 *
 * Contributors:
 *     Peter Lehmann <p.lehmann@t-systems.com>
 *     pele <p.lehmann@t-systems.com>
 */
/* 
 * Created on 27.06.2012
 * 
 * Copyright(c) 2011 - 2012 T-Systems Multimedia Solutions GmbH
 * Riesaer Str. 5, 01129 Dresden
 * All rights reserved.
 */
package eu.tsystems.mms.tic.testframework.mailconnector.util;

/** Creates a keychain with username, password and path to keystore file.  */
public class KeyChain {
    
    /** The username. */
    private String username;
    
    /** The path to keystore file. */
    private String path;
    
    /** The password. */
    private String password;
    
    /** Add the values to create the key. 
     * @param pathToFile
     *            The path to keystore file.
     * @param userName
     *            The username.
     * @param passWord
     *            The password.
     */
    public void addKey(final String pathToFile, final String userName, final String passWord) {
        this.username = userName;
        this.password = passWord;
        this.path = pathToFile;
    }
    
    /**
     * .
     * @return
     * .
     */
    public String getUserName() {
        return username;
    }
    
    /**
     * .
     * @return
     * .
     */
    public String getPath() {
        return path;
    }
    
    /**
     * .
     * @return
     * .
     */
    public String getPassWord() {
        return password;
    }
}