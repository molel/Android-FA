import { View, Text, StyleSheet } from "react-native";
import colors from "../theme/colors";

function Header() {
  return (
    <View style={styles.headerContainer}>
      <View style={styles.bottomHeaderBar}>
        <View style={styles.textContainer}>
          <Text style={styles.headerText}>GIF Gallery</Text>
        </View>
      </View>
    </View>
  );
}

const styles = StyleSheet.create({
  headerContainer: { width: "100%", height: "7%" },
  bottomHeaderBar: {
    flex: 11,
    backgroundColor: colors.primary,
  },
  textContainer: {
    marginVertical: "2%",
    marginHorizontal: "4%",
  },
  headerText: {
    color: colors.onPrimary,
    fontFamily: "sans-serif-light",
    fontSize: 27,
  },
});

export default Header;
