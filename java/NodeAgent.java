import Behaviours.*;
import DescriptionXml.ParserXml;
import jade.core.Agent;

public class NodeAgent extends Agent {

    @Override
    protected void setup() {
        ParserXml parserXml = new ParserXml("src/main/java/Resources/" + this.getLocalName() + ".xml");

        if (!parserXml.findFirstAgent().equals("Agent0")) {
            addBehaviour(new WaitInitBehaviour(
                    parserXml.findFirstAgent(),
                    parserXml.findLastAgent(),
                    parserXml.findNeighborsAgents(),
                    parserXml.findWeightNeighborsAgents()));
        } else {
            addBehaviour(new NodeForwardTransferBehaviours(parserXml.findNeighborsAgents(), parserXml.findWeightNeighborsAgents()));
            addBehaviour(new NodeBackTransferBehaviour());
        }
    }
}
