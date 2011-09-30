/*
 * Copyright (C) 2003-2011 eXo Platform SAS.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */
package org.exoplatform.social.sandbox.fsm;

import java.io.CharArrayReader;
import java.io.IOException;

import junit.framework.TestCase;

import org.exoplatform.social.sandbox.fsm.impl.CharacterFSM;

/**
 * Created by The eXo Platform SAS
 * Author : eXoPlatform
 *          exo@exoplatform.com
 * Sep 30, 2011  
 */
public class CharacterFSMTest extends TestCase {

  public void testRecognizeSimplePattern() throws IOException
  {
     Activity<Character> state_0, state_1, state_2, state_3, state_4, state_5, final_state;

     state_0 = Activity.newInstance("start", false);
     state_1 = Activity.newInstance("e", false);
     state_2 = Activity.newInstance("eX", false);
     state_3 = Activity.newInstance("eXo", false);
     state_4 = Activity.newInstance("eXo*", false);
     state_5 = Activity.newInstance("eXo*e", false);
     final_state = Activity.newInstance("eXo*er", true);

     //define transition table
     //state 0 -> 1
     state_0.connectTo('e', state_1);
     //state 1 -> 2
     state_1.connectTo('X', state_2);

     for(char c = 'A'; c <= 'z'; c++)
     {
        if(c != 'e')
        {
           state_0.connectTo(c, state_0);
        }

        if(c != 'o')
        {
           state_2.connectTo(c, state_3);
           state_3.connectTo(c, state_3);
        }
     }

     state_2.connectTo('o', state_4);
     state_3.connectTo('o', state_4);

     state_4.connectTo('e', state_5);
     state_5.connectTo('r', final_state);

     CharacterFSM stateMachine = new CharacterFSM(state_0){
        @Override
        protected void makeTransition()
        {
           Activity<Character> currentState = getCurrentState();
           Character letter = getCommingInput();
           setCurrentState(currentState.findTargetState(letter));
        }
     };

     assertTrue(stateMachine.accept(new CharArrayReader("hoangisaneXoer!".toCharArray())));
     stateMachine.reset();
     assertTrue(stateMachine.accept(new CharArrayReader("hoangisaneXklmnoer!".toCharArray())));
     stateMachine.reset();
     assertFalse(stateMachine.accept(new CharArrayReader("hoangisaneXoreXoe!".toCharArray())));
     stateMachine.reset();
     assertFalse(stateMachine.accept(new CharArrayReader("hoangisaneX  oer".toCharArray())));
  }
  
}
