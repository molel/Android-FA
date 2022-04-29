import { NavigationContainer } from "@react-navigation/native";
import { createNativeStackNavigator } from "@react-navigation/native-stack";
import { Button } from "react-native";
import Home from "../screens/Home";
import Contacts from "../screens/Contacts";
import Settings from "../screens/Settings";
import HeaderButton from "../components/HeaderButton";

const Stack = createNativeStackNavigator();

export default function Navigator(props) {
  return (
    <NavigationContainer>
      <Stack.Navigator initialRouteName="Home">
        <Stack.Screen
          name="Home"
          component={Home}
          options={{
            headerRight: () => (
              <HeaderButton text="Settings" screen="Settings" />
            ),
          }}
        />
        <Stack.Screen
          name="Contacts"
          component={Contacts}
          options={{
            headerRight: () => (
              <HeaderButton text="Settings" screen="Settings" />
            ),
          }}
        />
        <Stack.Screen name="Settings" component={Settings} />
      </Stack.Navigator>
    </NavigationContainer>
  );
}
