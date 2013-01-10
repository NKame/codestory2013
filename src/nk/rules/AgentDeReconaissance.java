package nk.rules;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.drools.KnowledgeBase;
import org.drools.KnowledgeBaseFactory;
import org.drools.builder.KnowledgeBuilder;
import org.drools.builder.KnowledgeBuilderFactory;
import org.drools.builder.ResourceType;
import org.drools.command.Command;
import org.drools.command.CommandFactory;
import org.drools.io.ResourceFactory;
import org.drools.runtime.StatelessKnowledgeSession;

public class AgentDeReconaissance {
	private KnowledgeBase kb;

	public AgentDeReconaissance(String rulesRessource) {
		KnowledgeBuilder kBuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
		kBuilder.add(ResourceFactory.newClassPathResource(rulesRessource, "UTF-8", this.getClass()),
				ResourceType.DRL);

		if (kBuilder.hasErrors()) {
			throw new RuntimeException(kBuilder.getErrors().toString());
		}

		kb = KnowledgeBaseFactory.newKnowledgeBase();
		kb.addKnowledgePackages(kBuilder.getKnowledgePackages());
	}

	/**
	 * Roule le moteur avec les objets passés en paramètres. Les collections sont automatiquement éclatées.
	 * 
	 * @param os
	 */
	public void roule(Object... os) {
		StatelessKnowledgeSession session = kb.newStatelessKnowledgeSession();
		List<Command<?>> cmds = new ArrayList<Command<?>>();
		for (Object o : os) {
			if (o instanceof Collection) {
				cmds.add(CommandFactory.newInsertElements((Collection<?>) o));
			} else {
				cmds.add(CommandFactory.newInsert(o));
			}
		}
		session.execute(CommandFactory.newBatchExecution(cmds));
	}
}
