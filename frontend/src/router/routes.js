import Board from "../views/Board";
import Task from "../views/Task";
import Error from "../views/Error";

export default [
  {
    path: "/",
    name: "board",
    component: Board,
    children: [
      {
        path: "task/:id",
        name: "task",
        component: Task
      }
    ]
  },
  {
    path: "/error",
    name: "error-modal",
    component: Error,
    props: true
  }
];
