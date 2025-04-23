package edu.iu.habahram.GumballMachine.model;

public class OutOfGumballsState implements IState {
    IGumballMachine gumballMachine;

    public OutOfGumballsState(IGumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public TransitionResult insertQuarter() {
        return new TransitionResult(false, "Machine is out of gumballs", gumballMachine.getTheStateName(), gumballMachine.getCount());
    }

    @Override
    public TransitionResult ejectQuarter() {
        return new TransitionResult(false, "You can't eject, you haven't inserted a quarter", gumballMachine.getTheStateName(), gumballMachine.getCount());
    }

    @Override
    public TransitionResult turnCrank() {
        return new TransitionResult(false, "You turned, but there are no gumballs", gumballMachine.getTheStateName(), gumballMachine.getCount());
    }

    @Override
    public TransitionResult dispense() {
        return new TransitionResult(false, "No gumball dispensed", gumballMachine.getTheStateName(), gumballMachine.getCount());
    }

    @Override
    public String getTheName() {
        return GumballMachineState.OUT_OF_GUMBALLS.name();
    }

    @Override
    public TransitionResult refill() {
        gumballMachine.changeTheStateTo(GumballMachineState.NO_QUARTER);
        return new TransitionResult(true, "Machine Refilled", gumballMachine.getTheStateName(), gumballMachine.getCount());
    }
}
