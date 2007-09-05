/*
 * CDDL HEADER START
 *
 * The contents of this file are subject to the terms of the
 * Common Development and Distribution License, Version 1.0 only
 * (the "License").  You may not use this file except in compliance
 * with the License.
 *
 * You can obtain a copy of the license at
 * trunk/opends/resource/legal-notices/OpenDS.LICENSE
 * or https://OpenDS.dev.java.net/OpenDS.LICENSE.
 * See the License for the specific language governing permissions
 * and limitations under the License.
 *
 * When distributing Covered Code, include this CDDL HEADER in each
 * file and include the License file at
 * trunk/opends/resource/legal-notices/OpenDS.LICENSE.  If applicable,
 * add the following below this CDDL HEADER, with the fields enclosed
 * by brackets "[]" replaced with your own identifying information:
 *      Portions Copyright [yyyy] [name of copyright owner]
 *
 * CDDL HEADER END
 *
 *
 *      Portions Copyright 2006-2007 Sun Microsystems, Inc.
 */


package org.opends.quicksetup.installer;

import java.util.LinkedList;


/**
 * This class is used to provide a data model for the Data Options panel of the
 * installer.
 *
 */
public class NewSuffixOptions
{
  /**
   * This enumeration is used to know what the user wants to do for the data
   * (import data or not, what use as source of the data...).
   *
   */
  public enum Type
  {
    /**
     * Do nothing.
     */
    NOTHING,
    /**
     * Create base entry.
     */
    CREATE_BASE_ENTRY,
    /**
     * Do not add any entry to the suffix.
     */
    LEAVE_DATABASE_EMPTY,
    /**
     * Import data from an LDIF file.
     */
    IMPORT_FROM_LDIF_FILE,
    /**
     * Generate data and import it to the suffix.
     */
    IMPORT_AUTOMATICALLY_GENERATED_DATA
  }

  private Type type = Type.NOTHING;

  private LinkedList<String> baseDns = new LinkedList<String>();

  private LinkedList<String> ldifPaths = new LinkedList<String>();

  private int numberEntries = 2000;

  /**
   * Constructor for the NewSuffixOptions object.
   *
   * If the Data Options is IMPORT_FROM_LDIF_FILE the args are the baseDn and
   * a String with the ldif location.
   *
   * If the Data Options is IMPORT_AUTOMATICALLY_GENERATED_DATA the args
   * are the baseDn and an Integer with the number of entries.
   *
   * For the rest of the types the args are just the baseDn.
   *
   * @param type the Type of NewSuffixOptions.
   * @param args the different argument objects (depending on the Type
   * specified)
   */
  public NewSuffixOptions(Type type, Object... args)
  {
    this.type = type;
    LinkedList<?> v = (LinkedList<?>)args[0];
    for (Object o : v)
    {
      baseDns.add((String)o);
    }
    switch (type)
    {
    case IMPORT_FROM_LDIF_FILE:
      v = (LinkedList<?>)args[1];
      for (Object o : v)
      {
        ldifPaths.add((String)o);
      }
      break;

    case IMPORT_AUTOMATICALLY_GENERATED_DATA:
      numberEntries = ((Integer) args[1]).intValue();
      break;
    }
  }

  /**
   * Returns the type of NewSuffixOptions represented by this object (import
   * data or not, what use as source of the data...).
   *
   * @return the type of NewSuffixOptions.
   */
  public Type getType()
  {
    return type;
  }

  /**
   * Returns the path of the LDIF file used to import data.
   * @return the path of the LDIF file used to import data.
   */
  public LinkedList<String> getLDIFPaths()
  {
    LinkedList<String> copy = new LinkedList<String>(ldifPaths);
    return copy;
  }

  /**
   * Returns the number of entries that will be automatically generated.
   *
   * @return the number of entries that will be automatically generated.
   */
  public int getNumberEntries()
  {
    return numberEntries;
  }

  /**
   * Returns the base DN of the suffix that will be created in the server.
   *
   * @return the base DN of the suffix that will be created in the server.
   */
  public LinkedList<String> getBaseDns()
  {
    LinkedList<String> copy = new LinkedList<String>(baseDns);
    return copy;
  }
}
