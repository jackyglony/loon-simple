package org.loon.framework.javase.game.action;

import org.loon.framework.javase.game.action.map.shapes.Vector2D;

/**
 * Copyright 2008 - 2009
 * 
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
 * 
 * @project loonframework
 * @author chenpeng
 * @email：ceponline@yahoo.com.cn
 * @version 0.1
 */
public class MoveAction implements IAction {
	
	private Vector2D vector2D;

	private double dx;

	private double dy;

	public MoveAction(Vector2D vector2D, double dx, double dy) {
		this.vector2D = vector2D;
		this.dx = dx;
		this.dy = dy;
	}

	public void doAction() {
		doAction(1);
	}

	public void doAction(long timer) {
		double x = vector2D.getX() + timer * dx;
		double y = vector2D.getY() + timer * dy;
		vector2D.setX(x);
		vector2D.setY(y);
	}
}
