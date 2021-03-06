package org.loon.framework.android.game.srpg.effect;

import org.loon.framework.android.game.core.LSystem;
import org.loon.framework.android.game.core.graphics.opengl.GLColor;
import org.loon.framework.android.game.core.graphics.opengl.GLEx;
import org.loon.framework.android.game.srpg.SRPGDelta;

/**
 * Copyright 2008 - 2011
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
public class SRPGRCohesionEffect extends SRPGEffect {

	private int t_x, t_y;

	private GLColor color;

	private SRPGDelta[] delta;

	public SRPGRCohesionEffect(int x, int y) {
		this(x, y, GLColor.orange);
	}

	public SRPGRCohesionEffect(int x, int y, GLColor color) {
		this.t_x = x;
		this.t_y = y;
		this.color = color;
		double[][] res = { { 0.0D, 30D }, { 24D, -15D }, { -24D, -15D } };
		this.delta = new SRPGDelta[8];
		delta[0] = new SRPGDelta(res, 2D, 0.0D, 36D);
		delta[1] = new SRPGDelta(res, 0.0D, 2D, 36D);
		delta[2] = new SRPGDelta(res, -2D, 0.0D, 36D);
		delta[3] = new SRPGDelta(res, 0.0D, -2D, 36D);
		delta[4] = new SRPGDelta(res, 1.3999999999999999D, 1.3999999999999999D, 36D);
		delta[5] = new SRPGDelta(res, -1.3999999999999999D, 1.3999999999999999D, 36D);
		delta[6] = new SRPGDelta(res, 1.3999999999999999D, -1.3999999999999999D, 36D);
		delta[7] = new SRPGDelta(res, -1.3999999999999999D, -1.3999999999999999D,
				36D);
		setExist(true);
	}

	public void draw(GLEx g, int x, int y) {
		next();
		g.setColor(color);
		for (int i = 0; i < delta.length; i++) {
			delta[i].drawPaint(g, t_x - x, LSystem.screenRect.height - (t_y - y));
		}
		if (super.frame > 40) {
			setExist(false);
		}
	}

}
