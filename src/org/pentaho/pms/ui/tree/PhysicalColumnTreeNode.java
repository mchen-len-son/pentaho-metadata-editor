/*
 * Copyright 2007 Pentaho Corporation.  All rights reserved. 
 * This software was developed by Pentaho Corporation and is provided under the terms 
 * of the Mozilla Public License, Version 1.1, or any later version. You may not use 
 * this file except in compliance with the license. If you need a copy of the license, 
 * please go to http://www.mozilla.org/MPL/MPL-1.1.txt. The Original Code is the Pentaho 
 * BI Platform.  The Initial Developer is Pentaho Corporation.
 *
 * Software distributed under the Mozilla Public License is distributed on an "AS IS" 
 * basis, WITHOUT WARRANTY OF ANY KIND, either express or  implied. Please refer to 
 * the license for the specific language governing your rights and limitations.
 *
 * @created Apr 30, 2007 
 * @author wseyler
 */


package org.pentaho.pms.ui.tree;

import java.util.List;

import org.eclipse.swt.graphics.Image;
import org.pentaho.di.core.dnd.DragAndDropContainer;
import org.pentaho.pms.schema.PhysicalColumn;
import org.pentaho.pms.schema.concept.ConceptInterface;
import org.pentaho.pms.ui.jface.tree.ITreeNode;
import org.pentaho.pms.ui.util.GUIResource;

/**
 * @author wseyler
 *
 */
public class PhysicalColumnTreeNode extends ConceptTreeNode {
  
  public void addDomainChild(Object obj) {
    // physical columns have no children
  }

  protected PhysicalColumn physicalColumn = null;
  protected String locale = null;

  /**
   * @param node
   * @param physicalColumn
   * @param locale
   */
  public PhysicalColumnTreeNode(ITreeNode parent, PhysicalColumn physicalColumn, String locale) {
    super(parent);
    
    this.physicalColumn = physicalColumn;
    this.locale = locale;
  }

  /* (non-Javadoc)
   * @see org.pentaho.pms.ui.tree.ConceptTreeNode#createChildren(java.util.List)
   */
  protected void createChildren(List children) {

  }
  
  public void sync(){
    fireTreeNodeUpdated();
   // Intentionally do nothing here 
  }

  /* (non-Javadoc)
   * @see org.pentaho.pms.jface.tree.ITreeNode#getName()
   */
  public String getName() {
    // TODO Auto-generated method stub
    return physicalColumn.getName(locale);
  }

  public int getDragAndDropType() {
    return DragAndDropContainer.TYPE_PHYSICAL_COLUMN;
  }

  public Object getDomainObject(){
    return physicalColumn;
  }

  public String getConceptName(){

    ConceptInterface concept = physicalColumn.getConcept();
    if (concept != null && concept.findFirstParentConcept() != null) {
      return concept.findFirstParentConcept().getName();
    }
    return null;
  }

  public Image getImage() {
    return GUIResource.getInstance().getImagePhysicalColumn();
  }
}