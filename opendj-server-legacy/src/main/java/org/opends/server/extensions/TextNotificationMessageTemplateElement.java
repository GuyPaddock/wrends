/*
 * The contents of this file are subject to the terms of the Common Development and
 * Distribution License (the License). You may not use this file except in compliance with the
 * License.
 *
 * You can obtain a copy of the License at legal/CDDLv1.0.txt. See the License for the
 * specific language governing permission and limitations under the License.
 *
 * When distributing Covered Software, include this CDDL Header Notice in each file and include
 * the License file at legal/CDDLv1.0.txt. If applicable, add the following below the CDDL
 * Header, with the fields enclosed by brackets [] replaced by your own identifying
 * information: "Portions Copyright [year] [name of copyright owner]".
 *
 * Copyright 2008 Sun Microsystems, Inc.
 * Portions Copyright 2014-2016 ForgeRock AS.
 */
package org.opends.server.extensions;

import org.forgerock.i18n.LocalizableMessageBuilder;
import org.opends.server.types.AccountStatusNotification;

/**
 * This class implements a notification message template element that will
 * generate a value using static text.
 */
public class TextNotificationMessageTemplateElement
       extends NotificationMessageTemplateElement
{
  /** The static text associated with this element. */
  private final String text;

  /**
   * Creates a new text notification message template element from the provided
   * string.
   *
   * @param  text  The string to use as the text for this element.
   */
  public TextNotificationMessageTemplateElement(String text)
  {
    this.text = text;
  }

  @Override
  public void generateValue(LocalizableMessageBuilder buffer,
                            AccountStatusNotification notification)
  {
    buffer.append(text);
  }
}
