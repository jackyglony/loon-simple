/**
 * MediaFrame is an Open Source streaming media platform in Java 
 * which provides a fast, easy to implement and extremely small applet 
 * that enables to view your audio/video content without having 
 * to rely on external player applications or bulky plug-ins.
 * 
 * Copyright (C) 2004/5 MediaFrame (http://www.mediaframe.org).
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 *
 */
/************************** MPEG-2 NBC Audio Decoder **************************
 *                                                                           
 * "This software module was originally developed by 
 * AT&T, Dolby Laboratories, Fraunhofer Gesellschaft IIS in the course of 
 * development of the MPEG-2 NBC/MPEG-4 Audio standard ISO/IEC 13818-7, 
 * 14496-1,2 and 3. This software module is an implementation of a part of one or more 
 * MPEG-2 NBC/MPEG-4 Audio tools as specified by the MPEG-2 NBC/MPEG-4 
 * Audio standard. ISO/IEC  gives users of the MPEG-2 NBC/MPEG-4 Audio 
 * standards free license to this software module or modifications thereof for use in 
 * hardware or software products claiming conformance to the MPEG-2 NBC/MPEG-4
 * Audio  standards. Those intending to use this software module in hardware or 
 * software products are advised that this use may infringe existing patents. 
 * The original developer of this software module and his/her company, the subsequent 
 * editors and their companies, and ISO/IEC have no liability for use of this software 
 * module or modifications thereof in an implementation. Copyright is not released for 
 * non MPEG-2 NBC/MPEG-4 Audio conforming products.The original developer
 * retains full right to use the code for his/her  own purpose, assign or donate the 
 * code to a third party and to inhibit third party from using the code for non 
 * MPEG-2 NBC/MPEG-4 Audio conforming products. This copyright notice must
 * be included in all copies or derivative works." 
 * Copyright(c)1996.
 * 
 ******************************************************************************/                                                                          
package mediaframe.mpeg4.audio.AAC;

/**
 * MC_Info
 */
final class MC_Info {

	/** total number of audio channels */
	int nch = 0;		
	/** number of front SCE's pror to first front CPE */
	int nfsce = 0;		
	/** number of front channels */
	int nfch = 0;		
	/** number of side channels */
	int nsch = 0;		
	/** number of back channels */
	int nbch = 0;		
	/** number of lfe channels */
	int nlch = 0;		
	/** number of valid coupling channels */
	int ncch = 0;		
	/** tags of valid CCE's */
	int[] cch_tag = new int[1 << Constants.LEN_TAG];	
	/** The profile of the AAC stream. */
	int profile;
	/** The index for the sampling frequency (@see Tables.SampleIndexRateTable). */	
	int sampling_rate_idx;
	/** The sampling frequency value. */	
	int sampling_rate;
	
	Ch_Info[] ch_info = new Ch_Info[Constants.Chans];
	
	MC_Info() {
		super();
		for(int i = 0; i < ch_info.length; i++) {
			ch_info[i] = new Ch_Info(); 
		}
	}
}
