import numpy as np

class ElevatorSystem:
    def __init__(self):
        self._elevators = [Elevator(i+1) for i in range(16)]

    def pickup(self, src_floor, direction):
        pass

    def update(self, elevator_id, current_floor, dst_floor):
        elevator = self._elevators[elevator_id - 1]
        elevator.set_current_floor(current_floor)
        elevator.set_dst_floor(dst_floor) 

    def step(self):
        pass
    def status(self):
        return [(elevator.get_id(), elevator.get_current_floor(), elevator.get_dst_floor()) for elevator in self._elevators]


class Elevator:
    def __init__(self, elevator_id, current_floor=0, dst_floor=None):
        self._elevator_id = elevator_id
        self._current_floor = current_floor
        self._dst_floor = dst_floor

    def get_id(self):
        return self._elevator_id
    
    def get_current_floor(self):
        return self._current_floor
    
    def get_dst_floor(self):
        return self._dst_floor
    
    def set_current_floor(self, floor):
        self._current_floor = floor
    
    def set_dst_floor(self, floor):
        self._dst_floor = floor

el_system = ElevatorSystem()
print(el_system.status())