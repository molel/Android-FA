import { NavigationContainer } from "@react-navigation/native";
import { createBottomTabNavigator } from "@react-navigation/bottom-tabs";
import Login from "./components/Login";
import Exercises from "./components/Exercises";
import { AntDesign } from "@expo/vector-icons";

const Tab = createBottomTabNavigator();

export default function App() {
  return (
    <NavigationContainer>
      <Tab.Navigator
        initialRouteName="Упражнения"
        screenOptions={{ headerShown: false }}
      >
        <Tab.Screen
          name="Упражнения"
          component={Exercises}
          options={{
            tabBarIcon: ({ color, size }) => (
              <AntDesign name="bars" color={color} size={size} />
            ),
          }}
        />
        <Tab.Screen
          name="Авторизация"
          component={Login}
          options={{
            tabBarIcon: ({ color, size }) => (
              <AntDesign name="login" color={color} size={size} />
            ),
          }}
        />
      </Tab.Navigator>
    </NavigationContainer>
  );
}
