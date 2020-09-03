import routes from "../src/router/routes";
import VueRouter from "vue-router";

export default {
  mock() {
    const clearedRoutes = mockCouterComponents(routes);
    return new VueRouter({
      mode: "history",
      routes: clearedRoutes
    });
  }
};

function mockCouterComponents(routes) {
  const dummyComponent = { template: "<p>foo</p>" };
  const routesToClear = JSON.parse(JSON.stringify(routes));
  routesToClear.forEach(route => {
    route.component = dummyComponent;
  });
  return routesToClear;
}
