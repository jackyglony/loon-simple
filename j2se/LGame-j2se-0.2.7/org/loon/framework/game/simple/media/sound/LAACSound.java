package org.loon.framework.game.simple.media.sound;

import java.io.InputStream;

import mediaframe.mpeg4.audio.AACAudioPlayer;

import org.loon.framework.game.simple.core.resource.Resources;

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
public class LAACSound implements Sound {

	private int volume;

	private AACAudioPlayer player;

	public LAACSound() {
		setSoundVolume(Sound.defaultMaxVolume);
	}

	public void playSound(String fileName) {
		playSound(Resources.getResourceAsStream(fileName));
	}

	public void playSound(InputStream in) {
		try {
			stopSound();
			player = new AACAudioPlayer(in, 0);
			setSoundVolume(volume);
			player.play();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setSoundVolume(int volume) {
		this.volume = volume;
		if (this.player == null) {
			return;
		}
		player.setVolume(volume);

	}

	public void stopSound() {
		if (this.player == null) {
			return;
		}
		player.stop();

	}

	public boolean isVolumeSupported() {
		return true;
	}

}
