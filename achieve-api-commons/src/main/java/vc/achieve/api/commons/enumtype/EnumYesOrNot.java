package vc.achieve.api.commons.enumtype;

/**
 * <p><code>Enum</code> for commons types.</p>
 * 
 * </br>
 * 
 * <p>
 * 	<ul><b>Values</b>
 * 		<li>YES</li>
 * 		<li>NO</li>
 * 	</ul> 
 * </p>
 * 
 * @author GAN
 * @since 1.0
 */
public enum EnumYesOrNot {
	
	YES {
		@Override
		public String toString() {
			return "YES";
		}
	},
	
	NO {
		@Override
		public String toString() {
			return "NO";
		}
	}

}
