/*
 * Copyright 2018 OrientDB.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.orientechnologies.orient.core.db.record.ridbag.linked;

import com.orientechnologies.orient.core.db.record.OIdentifiable;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author mdjurovi
 */
public class ORidbagListNode extends ORidbagNode{

  private final List<OIdentifiable> rids = new LinkedList<>();
  
  protected ORidbagListNode(OIdentifiable rid){
    super(rid);
  }
  
  @Override
  protected int capacity() {
    return Integer.MAX_VALUE;
  }

  @Override
  protected void addInternal(OIdentifiable value) {
    rids.add(value);    
  }

  @Override
  protected void addAllInternal(OIdentifiable[] values) {
    for (OIdentifiable val : values){
      rids.add(val);
    }
  }

  @Override
  protected OIdentifiable getAt(int index) {
    return rids.get(index);
  }

  @Override
  protected boolean remove(OIdentifiable value) {
    return rids.remove(value);
  }

  @Override
  protected boolean contains(OIdentifiable value) {
    return rids.contains(value);
  }

  @Override
  protected void loadInternal() {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  protected boolean isTailNode() {
    return rids.size() > 0;
  }

  @Override
  protected OIdentifiable[] getAllRids() {
    return rids.toArray(new OIdentifiable[0]);
  }

  @Override
  protected void setAt(OIdentifiable value, int index) {
    rids.set(index, value);
  }
  
  @Override
  protected void reset(){
    super.reset();
    rids.clear();
  }
  
  @Override
  protected byte getNodeType(){
    return 'l';
  }
  
}
